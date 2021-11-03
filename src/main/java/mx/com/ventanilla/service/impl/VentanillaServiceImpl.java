package mx.com.ventanilla.service.impl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.micronaut.context.annotation.Value;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.client.RxHttpClient;
import java.net.URI;
import java.net.URL;
import java.util.Map;
import java.util.Objects;
import javax.inject.Inject;
import javax.inject.Singleton;
import mx.com.ventanilla.dto.request.PeticionToken;
import mx.com.ventanilla.dto.RespuestaGenerica;
import mx.com.ventanilla.dto.request.Input;
import mx.com.ventanilla.dto.response.RespuestaToken;
import mx.com.ventanilla.exception.ServiceException;
import mx.com.ventanilla.service.VentanillaService;
import mx.com.ventanilla.utils.Constantes;
import mx.com.ventanilla.utils.Json;
import mx.com.ventanilla.utils.Utilidades;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Singleton
public class VentanillaServiceImpl implements VentanillaService {

    private static final Logger log = LoggerFactory.getLogger(VentanillaServiceImpl.class);

    @Value("${bpm.host}")
    private String host;

    @Value("${bpm.token}")
    private String urlToken;

    @Value("${bpm.instance}")
    private String urlInstance;

    @Value("${bpm.instance-cliente}")
    private String urlInstanceCliente;

    @Value("${bpm.instance-tasks}")
    private String urlInstanceTasks;

    @Value("${bpm.finish-task}")
    private String urlFinishTask;
    
    @Value("${bpm.user}")
    private String user;

    @Value("${bpm.pass}")
    private String pass;

    @Inject
    RxHttpClient httpClient;

    public RespuestaGenerica obtenToken() throws ServiceException {
        try {
            RespuestaGenerica respuesta = new RespuestaGenerica();
            PeticionToken token = new PeticionToken();
            token.setRefresh_groups(Constantes.REFRESCAR);
            token.setRequested_lifetime(Constantes.TIEMPO_VIDA_TOKEN);
            RespuestaToken result = httpClient.toBlocking().retrieve((HttpRequest.POST(host + urlToken, token).basicAuth(user, pass)), RespuestaToken.class);
            if (!Objects.isNull(result)) {
                respuesta.setDatos(result);
                return respuesta;
            }
        } catch (Exception s) {
            throw new ServiceException("Error al obtener Token", s);
        }
        return null;
    }

    @Override
    public RespuestaGenerica obtenInstancia(Input input) throws ServiceException {
        try {
            RespuestaGenerica respuesta = obtenToken();
            RespuestaToken result = (RespuestaToken) respuesta.getDatos();
            if (!Objects.isNull(result)) {
                log.info("Obtiene el token: {}", result.getCsrf_token());
                String url = host + urlInstance + Constantes.PARAM_MODEL + Constantes.PARAM_CONTAINER + Constantes.PARAM_OPTIONAL;
                log.info("Llamado de Instancia : {}", url);
                String resultado = httpClient.toBlocking().retrieve(HttpRequest.POST(URI.create(url), input)
                        .basicAuth(user, pass)
                        .header(Constantes.HEADER_TOKEN, result.getCsrf_token()));
                if (!Objects.isNull(resultado) && !resultado.isEmpty()) {
                    log.info("Exito: {} ", resultado);
                    respuesta.setDatos(resultado);
                    respuesta.setMensaje(Constantes.EXITO);
                    respuesta.setResultado(true);
                }
            }
            return respuesta;
        } catch (Exception e) {
            throw new ServiceException("Error al Crear Instancia", e);
        }
    }

    @Override
    public RespuestaGenerica obtenTareasCliente(Long idCliente) throws ServiceException {
        try {
            RespuestaGenerica respuesta = obtenToken();
            RespuestaToken result = (RespuestaToken) respuesta.getDatos();
            if (!Objects.isNull(result)) {
                log.info("Obtiene el token: {}", result.getCsrf_token());
                String url = host + urlInstanceCliente + idCliente + Constantes.PARAMS_CLIENT;
                log.info("Llamado de Instancia : {}", url);
                String resultado = httpClient.toBlocking().retrieve(HttpRequest.POST(URI.create(url), "")
                        .basicAuth(user, pass)
                        .header(Constantes.HEADER_TOKEN, result.getCsrf_token()));
                log.info("Exito: {} ", resultado);
                respuesta.setDatos(resultado);
                respuesta.setMensaje(Constantes.EXITO);
                respuesta.setResultado(true);
            }
            return respuesta;
        } catch (Exception e) {
            throw new ServiceException("Error al obtener tareas del cliente", e);
        }
    }

    @Override
    public RespuestaGenerica obtenTareasInstancia(Long instanciaId) throws ServiceException {
        try {
            RespuestaGenerica respuesta = obtenToken();
            RespuestaToken result = (RespuestaToken) respuesta.getDatos();
            if (!Objects.isNull(result)) {
                log.info("Obtiene el token: {}", result.getCsrf_token());
                String url = host + urlInstanceTasks + instanciaId + Constantes.PARAMS_TASKS;
                log.info("Llamado de tareas por instancia : {}", url);
                String resultado = httpClient.toBlocking().retrieve(HttpRequest.GET(URI.create(url))
                        .basicAuth(user, pass)
                        .header(Constantes.HEADER_TOKEN, result.getCsrf_token()));
                log.info("Exito: {} ", resultado);
                respuesta.setDatos(resultado);
                respuesta.setMensaje(Constantes.EXITO);
                respuesta.setResultado(true);
            }
            return respuesta;
        } catch (Exception e) {
            throw new ServiceException("Error al obtener tareas de la instancia", e);
        }
    }

    @Override
    public RespuestaGenerica addData(Long tareaId, String params) throws ServiceException {
        try {
            RespuestaGenerica respuesta = obtenToken();
            RespuestaToken result = (RespuestaToken) respuesta.getDatos();
            if (!Objects.isNull(result)) {
                log.info("Obtiene el token: {}", result.getCsrf_token());
                String url = host + urlFinishTask + tareaId + Constantes.PARAMS_ADD + Utilidades.encodingParams(params);
                log.info("Llamado de set Data tarea : {}", url);
                log.info("URL a ejecutar: {}", URI.create(url));
                String resultado = httpClient.toBlocking().retrieve(HttpRequest.PUT(URI.create(url), "") 
                        .basicAuth(user, pass)
                        .header(Constantes.HEADER_TOKEN, result.getCsrf_token()));
                
                if (!Objects.isNull(resultado) && !resultado.isEmpty()) {
                    log.info("Exito: {} ", resultado);
                    respuesta.setDatos(resultado);
                    respuesta.setMensaje(Constantes.EXITO);
                    respuesta.setResultado(true);
                }
            }
            return respuesta;
        } catch (Exception e) {
            throw new ServiceException("Error al settear datos a la instancia", e);
        }
    }

    @Override
    public RespuestaGenerica finalizaTarea(Long tareaId) throws ServiceException {
        try {
            RespuestaGenerica respuesta = obtenToken();
            RespuestaToken result = (RespuestaToken) respuesta.getDatos();
            if (!Objects.isNull(result)) {
                log.info("Obtiene el token: {}", result.getCsrf_token());
                String url = host + urlFinishTask + tareaId + Constantes.PARAMS_FINISH_TASK + result.getCsrf_token();
                log.info("Llamado de finalizar tarea : {}", url);
                String resultado = httpClient.toBlocking().retrieve(HttpRequest.PUT(URI.create(url),"")
                        .basicAuth(user, pass)
                        .header(Constantes.HEADER_TOKEN, result.getCsrf_token()));
                log.info("Exito: {} ", resultado);
                respuesta.setDatos(resultado);
                respuesta.setMensaje(Constantes.EXITO);
                respuesta.setResultado(true);
            }
            return respuesta;
        } catch (Exception e) {
            throw new ServiceException("Error al finalizar la tarea", e);
        }
    }
    
    @Override
    public RespuestaGenerica obtenInfoTarea(Long tareaId) throws ServiceException {
        try {
            RespuestaGenerica respuesta = obtenToken();
            RespuestaToken result = (RespuestaToken) respuesta.getDatos();
            if (!Objects.isNull(result)) {
                log.info("Obtiene el token: {}", result.getCsrf_token());
                String url = host + urlFinishTask + tareaId + Constantes.PARAM_DATA;
                log.info("Llamado de obtener datos tarea : {}", url);
                String resultado = httpClient.toBlocking().retrieve(HttpRequest.GET(URI.create(url))
                        .basicAuth(user, pass)
                        .header(Constantes.HEADER_TOKEN, result.getCsrf_token()));
                log.info("Exito: {} ", resultado);
                respuesta.setDatos(resultado);
                respuesta.setMensaje(Constantes.EXITO);
                respuesta.setResultado(true);
            }
            return respuesta;
        } catch (Exception e) {
            throw new ServiceException("Error al obtener data", e);
        }
    }
    
    

}
