package service;

import domain.Charactor;
import dto.CharactorDto;
import repository.CharactorRepository;

import java.util.List;

public class PlayerStatusService {

    private CharactorRepository charactorRepository = null;

    public void HpChange(int cHp, Long id){
        int hp = findById(id).getHp();
        if (hp + cHp > findById(id).getMaxHp()){
            hp = findById(id).getMaxHp();
        }
        else if (hp + cHp > 0){
            hp += cHp;
        }
        else{
            hp = 0;
        }

        CharactorDto charactorDto = new CharactorDto();
        charactorDto.setHp(hp);

        update_hp(charactorDto);
    }

    public boolean GoldChange(int cGold, Long id){
        int gold = findById(id).getGold();
        if (gold + cGold < 0){
            return false;
        }
        else{
            CharactorDto charactorDto = new CharactorDto();
            charactorDto.setGold(gold + cGold);
            update_gold(charactorDto);
            return true;
        }
    }

    public void save(CharactorDto charactorDto){
        charactorRepository.save(charactorDto.toEntity());
    }

    public Charactor findById(Long id){
        return charactorRepository.findById(id);
    }

    public void update_name(CharactorDto charactorDto){
        charactorRepository.update_name(charactorDto.toEntity());
    }

    public void update_maxHp(CharactorDto charactorDto){
        charactorRepository.update_maxHp(charactorDto.toEntity());
    }

    public void update_hp(CharactorDto charactorDto){
        charactorRepository.update_hp(charactorDto.toEntity());

    }

    public void update_atk(CharactorDto charactorDto){
        charactorRepository.update_atk(charactorDto.toEntity());
    }

    public void update_def(CharactorDto charactorDto){
        charactorRepository.update_def(charactorDto.toEntity());
    }

    public void update_gold(CharactorDto charactorDto){
        charactorRepository.update_gold(charactorDto.toEntity());
    }

    public void update_speed (CharactorDto charactorDto){
        charactorRepository.update_speed(charactorDto.toEntity());
    }

}