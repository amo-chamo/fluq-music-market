package org.amochamo.fluqmusicmarket.services.userstuff;

import org.amochamo.fluqmusicmarket.repositories.userstuff.LibraryRepository;
import org.springframework.stereotype.Service;

@Service
public class LibraryService {

    private final LibraryRepository libraryRepository;

    public LibraryService(LibraryRepository libraryRepository) {
        this.libraryRepository = libraryRepository;
    }

}
