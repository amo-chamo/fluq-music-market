package org.amochamo.fluqmusicmarket.services.artiststuff;

import org.amochamo.fluqmusicmarket.repositories.artiststuff.UploadRequestRepository;
import org.springframework.stereotype.Service;

@Service
public class UploadRequestService {

    private final UploadRequestRepository uploadRequestRepository;

    public UploadRequestService(UploadRequestRepository uploadRequestRepository) {
        this.uploadRequestRepository = uploadRequestRepository;
    }

}
