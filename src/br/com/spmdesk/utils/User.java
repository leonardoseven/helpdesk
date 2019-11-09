package br.com.spmdesk.utils;

import br.com.spmdesk.entity.Usuario;

public class User {
	
    private static Usuario instance;

    public static Usuario setUsuario(Usuario usuario) {
        if (instance == null) {
        	instance = usuario;
        }
        return instance;
 
	}
    
    public static Usuario getUsuario() {
        return instance;
	}
}
