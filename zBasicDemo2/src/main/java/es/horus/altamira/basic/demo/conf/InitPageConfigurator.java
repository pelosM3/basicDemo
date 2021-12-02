package es.horus.altamira.basic.demo.conf;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.server.InitialPageSettings;
import com.vaadin.flow.server.PageConfigurator;

@Tag(value = "a")
public class InitPageConfigurator extends Component implements PageConfigurator {

   @Override
   public void configurePage(InitialPageSettings settings) {
       // Textos de perdida de conexion
       settings.getReconnectDialogConfiguration().setDialogText("Reconenctando");
       settings.getReconnectDialogConfiguration().setDialogTextGaveUp("Conexion perdida");
       // Configuracion del indicador de cargando
       settings.getLoadingIndicatorConfiguration().setApplyDefaultTheme(false);
       // Icono
       settings.addFavIcon("icon", "favicon.ico", "16x16");
   }
}
