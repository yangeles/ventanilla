
package mx.com.ventanilla.service;

import mx.com.ventanilla.dto.RespuestaGenerica;
import mx.com.ventanilla.exception.ServiceException;
import mx.com.ventanilla.dto.request.Input;

import java.io.IOException;


public interface VentanillaService {
    
    RespuestaGenerica obtenToken() throws ServiceException;
    RespuestaGenerica obtenInstancia(Input input) throws ServiceException, IOException;
    RespuestaGenerica obtenTareasCliente(Long idCliente) throws ServiceException;
    RespuestaGenerica obtenTareasInstancia(Long instanciaId) throws ServiceException;
    RespuestaGenerica addData(Long tareaId, String params) throws ServiceException;
    RespuestaGenerica finalizaTarea(Long tareaId) throws ServiceException;
    RespuestaGenerica obtenInfoTarea(Long tareaId) throws ServiceException;
}
