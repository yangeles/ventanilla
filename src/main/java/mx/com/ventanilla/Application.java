package mx.com.ventanilla;

import io.micronaut.core.annotation.Introspected;
import io.micronaut.data.annotation.AutoPopulated;
import io.micronaut.data.annotation.GeneratedValue;
import io.micronaut.data.annotation.Id;
import io.micronaut.data.annotation.MappedEntity;
import io.micronaut.data.annotation.MappedProperty;
import io.micronaut.runtime.Micronaut;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.servers.Server;

import javax.inject.Singleton;
import java.util.TimeZone;

@OpenAPIDefinition(
        info = @Info(
                title = "${ventanilla.aplicacion.nombre}",
                version = "${ventanilla.aplicacion.version}",
                description = "${ventanilla.aplicacion.descripcion}",
                license = @License(name = "${ventanilla.aplicacion.license}", url = "${ventanilla.aplicacion.license.url}"),
                contact = @Contact(url = "${ventanilla.aplicacion.contact.url}",
                        name = "${ventanilla.aplicacion.contacto.nombre}", email = "${ventanilla.aplicacion.contacto.email}")
        ),
        servers = {
                @Server(url = "${ventanilla.servidor.local}", description = "${ventanilla.servidor.local.descripcion}"),
                @Server(url = "${ventanilla.servidor.desarrollo}", description = "${ventanilla.servidor.desarrollo.descripcion}")
        }
)
@Introspected(packages = "mx.com.ventanilla.*",
        includedAnnotations = {MappedEntity.class, Id.class, MappedProperty.class,
                GeneratedValue.class, Introspected.class,  AutoPopulated.class, Singleton.class} )
public class Application {

    public static void main(String[] args) {
        TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
        Micronaut.run(Application.class, args);
    }
}
