package mx.com.ventanilla.controller;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import javax.inject.Inject;
import mx.com.ventanilla.dto.RespuestaGenerica;
import mx.com.ventanilla.dto.request.Input;
import mx.com.ventanilla.service.VentanillaService;
import mx.com.ventanilla.utils.Utilidades;

@Controller("/ventanilla")
public class VentanillaController {
        
    @Inject private VentanillaService service;

    @Operation(summary = "${ventanilla.controller}",
            description = "${ventanilla.controller}",
            operationId = "ventanilla.generarToken")
    @ApiResponse(content = @Content(mediaType = MediaType.APPLICATION_JSON),responseCode = "200", description = "Respuesta correcta")
    @Tag(name = "Ventanilla - Genera Token")
    @Get(value = "/generarToken", consumes = MediaType.APPLICATION_JSON, processes = MediaType.APPLICATION_JSON)
    public HttpResponse<RespuestaGenerica> generarToken() {
        try {
            return HttpResponse.ok(service.obtenToken());
        }catch (Exception e){
            return HttpResponse.badRequest(Utilidades.respuestaError());
        }
    }

    @Operation(summary = "${ventanilla.controller}",
            description = "${ventanilla.controller}",
            operationId = "ventanilla.generaInstancia")
    @ApiResponse(content = @Content(mediaType = MediaType.APPLICATION_JSON),responseCode = "200", description = "Respuesta correcta")
    @Tag(name = "Ventanilla - Genera Instancia")
    @Post(value = "/creaInstancia", consumes = MediaType.APPLICATION_JSON, processes = MediaType.APPLICATION_JSON)
    public HttpResponse<RespuestaGenerica> creaInstancia(@Body Input input) {
        try {
            return HttpResponse.ok(service.obtenInstancia(input));
        }catch (Exception e){
            return HttpResponse.badRequest(Utilidades.respuestaError());
        }
    }

    @Operation(summary = "${ventanilla.controller}",
            description = "${ventanilla.controller}",
            operationId = "ventanilla.tareasCliente")
    @ApiResponse(content = @Content(mediaType = MediaType.APPLICATION_JSON),responseCode = "200", description = "Respuesta correcta")
    @Tag(name = "Ventanilla - Tareas por Cliente")
    @Post(value = "/tareasCliente/{idCliente}", consumes = MediaType.APPLICATION_JSON, processes = MediaType.APPLICATION_JSON)
    public HttpResponse<RespuestaGenerica> tareasCliente(@PathVariable Long idCliente) {
        try {
            return HttpResponse.ok(service.obtenTareasCliente(idCliente));
        }catch (Exception e){
            return HttpResponse.badRequest(Utilidades.respuestaError());
        }
    }

    @Operation(summary = "${ventanilla.controller}",
            description = "${ventanilla.controller}",
            operationId = "ventanilla.tareasInstancia")
    @ApiResponse(content = @Content(mediaType = MediaType.APPLICATION_JSON),responseCode = "200", description = "Respuesta correcta")
    @Tag(name = "Ventanilla - Tareas por Instancia")
    @Get(value = "/tareasInstancia/{instanciaId}", consumes = MediaType.APPLICATION_JSON, processes = MediaType.APPLICATION_JSON)
    public HttpResponse<RespuestaGenerica> tareasInstancia(@PathVariable Long instanciaId) {
        try {
            return HttpResponse.ok(service.obtenTareasInstancia(instanciaId));
        }catch (Exception e){
            return HttpResponse.badRequest(Utilidades.respuestaError());
        }
    }

    @Operation(summary = "${ventanilla.controller}",
            description = "${ventanilla.controller}",
            operationId = "ventanilla.addFata")
    @ApiResponse(content = @Content(mediaType = MediaType.APPLICATION_JSON),responseCode = "200", description = "Respuesta correcta")
    @Tag(name = "Ventanilla - Agrega datos a la tarea")
    @Put(value = "/addData/{tareaId}/{params}", consumes = MediaType.APPLICATION_JSON, processes = MediaType.APPLICATION_JSON)
    public HttpResponse<RespuestaGenerica> addData(@PathVariable Long tareaId, @PathVariable String params) {
        try {
            return HttpResponse.ok(service.addData(tareaId, params));
        }catch (Exception e){
            return HttpResponse.badRequest(Utilidades.respuestaError());
        }
    }

    @Operation(summary = "${ventanilla.controller}",
            description = "${ventanilla.controller}",
            operationId = "ventanilla.finalizaTarea")
    @ApiResponse(content = @Content(mediaType = MediaType.APPLICATION_JSON),responseCode = "200", description = "Respuesta correcta")
    @Tag(name = "Ventanilla - Finaliza Tarea")
    @Put(value = "/finalizaTarea/{tareaId}", consumes = MediaType.APPLICATION_JSON, processes = MediaType.APPLICATION_JSON)
    public HttpResponse<RespuestaGenerica> finalizaTarea(@PathVariable Long tareaId) {
        try {
            return HttpResponse.ok(service.finalizaTarea(tareaId));
        }catch (Exception e){
            return HttpResponse.badRequest(Utilidades.respuestaError());
        }
    }
}
