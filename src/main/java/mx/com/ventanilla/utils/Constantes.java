package mx.com.ventanilla.utils;

public class Constantes {

    private Constantes() {
        super();
    }

    public static final Boolean ESTATUS_ACTIVO = true;
    public static final Boolean ESTATUS_INACTIVO = false;
    public static final Boolean RESULTADO_EXITO = true;
    public static final Boolean RESULTADO_ERROR = false;
    public static final String EXITO = "Operación realizada con éxito";
    public static final String ERROR = "Ocurrió un error inesperado, intente más tarde, si el problema continúa llame a soporte técnico";
    public static final Long TIEMPO_VIDA_TOKEN = 7200L;
    public static final Boolean REFRESCAR = true;
    public static final CharSequence HEADER_TOKEN = "BPMCSRFToken";
    public static final String PARAM_MODEL = "?model=VentanillaDigital";
    public static final String PARAM_CONTAINER = "&container=VD";
    public static final String PARAM_OPTIONAL= "&optional_parts=data";
    public static final String PARAMS_CLIENT = "&organization=byInstance&run=true&shared=false&filterByCurrentUser=false";
    public static final String PARAMS_TASKS = "?parts=header%7Cdata";
    public static final String PARAMS_FINISH_TASK = "?action=finish&parts=all&BPMCSRFToken=";
    public static final String PARAMS_ADD = "?action=setData&params=";
    public static final String PARAM_DATA = "?parts=data";
    
}
