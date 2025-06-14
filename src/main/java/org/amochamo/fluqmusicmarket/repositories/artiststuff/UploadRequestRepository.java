package org.amochamo.fluqmusicmarket.repositories.artiststuff;

import org.amochamo.fluqmusicmarket.models.artiststuff.UploadRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UploadRequestRepository extends JpaRepository<UploadRequest, Integer> {
}
