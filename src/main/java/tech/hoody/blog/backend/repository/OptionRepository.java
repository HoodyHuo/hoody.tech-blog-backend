package tech.hoody.blog.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.hoody.blog.backend.domain.Option;

/**
 * OptionDao
 *
 * @author hoody
 * @since 2022/5/25
 */
public interface OptionRepository extends JpaRepository<Option,String > {

}
