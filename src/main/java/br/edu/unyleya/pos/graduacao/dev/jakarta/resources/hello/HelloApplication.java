package br.edu.unyleya.pos.graduacao.dev.jakarta.resources.hello;

import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.core.Application;

@ApplicationPath("rest")
public class HelloApplication extends Application {
  // Needed to enable Jakarta REST and specify path.    
}
