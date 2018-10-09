package com.pgrsoft.gestionpedidos.backend.pruebas.imagestorage;

public class StorageException extends RuntimeException {
	private static final long serialVersionUID = 15436543L;

	public StorageException(String message) {
        super(message);
    }

    public StorageException(String message, Throwable cause) {
        super(message, cause);
    }
}
