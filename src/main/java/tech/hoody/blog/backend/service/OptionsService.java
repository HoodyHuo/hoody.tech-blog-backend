package tech.hoody.blog.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.hoody.blog.backend.repository.OptionRepository;
import tech.hoody.blog.backend.domain.Option;

/**
 * OptionsService
 *
 * @author hoody
 * @since 2022/5/25
 */
@Service
public class OptionsService {

    private final OptionRepository optionRepository;

    @Autowired
    public OptionsService(OptionRepository optionRepository) {
        this.optionRepository = optionRepository;
    }

    public Option saveOption(Option option){
        optionRepository.save(option);
        return option;
    }
}
