package br.com.reactivebank.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Operation type repository for database.
 *
 * @author Lucas Araújo - lucas.compufc@gmail.com
 * @version 0.1
 * @since 10/03/21
 */
@Repository
public interface OperationTypeRepository extends ReactiveCrudRepository<OperationTypeRepository, Long> {
}
