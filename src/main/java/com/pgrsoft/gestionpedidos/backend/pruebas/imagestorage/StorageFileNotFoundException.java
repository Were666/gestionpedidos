package com.pgrsoft.gestionpedidos.backend.pruebas.imagestorage;

public class StorageFileNotFoundException extends StorageException {
	private static final long serialVersionUID = 5435441L;

	public StorageFileNotFoundException(String message) {
        super(message);
    }

    public StorageFileNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
