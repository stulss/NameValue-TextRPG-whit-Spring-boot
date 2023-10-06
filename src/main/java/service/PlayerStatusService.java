package service;

import domain.Charactor;
import dto.CharactorDto;
import repository.CharactorRepository;

public class PlayerStatusService {

    private CharactorRepository charactorRepository = null;

    public PlayerStatusService(){
        charactorRepository = new CharactorRepository();
        charactorRepository.createTable();
        charactorRepository.initialize();
    }

    // ----------------------PlayerStatus------------------------------

    public void HpChange(CharactorDto charactorDto,int cHp){
        int hp = charactorDto.getHp();
        if (hp + cHp > charactorDto.getMaxHp()){
            hp = charactorDto.getMaxHp();
        }
        else if (hp + cHp > 0){
            hp += cHp;
        }
        else{
            hp = 0;
        }

        charactorDto.setHp(hp);
        System.out.print(charactorDto.getName());
        DialogReadService.getDialog("PrintHp");
        System.out.println(charactorDto.getHp());
        update(charactorDto);
    }

    public boolean GoldChange(CharactorDto charactorDto,int cGold){
        int gold = charactorDto.getGold();
        if (gold + cGold < 0){
            DialogReadService.getDialog("PoorDialog");
            return false;
        }
        else{
            charactorDto.setGold(gold + cGold);
            update(charactorDto);
            System.out.print(charactorDto.getName());
            DialogReadService.getDialog("PrintGold");
            System.out.println(charactorDto.getGold());
            return true;
        }
    }

    public void printStatus(){
        Charactor user = findById(1L);
        System.out.println("===========정보창============");
        System.out.println("이름 : " + user.getName());
        System.out.println("체력 : " + user.getHp() + " / " + user.getMaxHp());
        System.out.println("공격력 : " + user.getAtk());
        System.out.println("방어력 : " + user.getDef());
        System.out.println("골드 : " + user.getGold());
        System.out.println("=============================");
        System.out.println();
    }

    public void save(CharactorDto charactorDto){
        charactorRepository.save(charactorDto.toEntity());
    }

    public Charactor findById(Long id){
        return charactorRepository.findById(id);
    }

    public void update(CharactorDto charactorDto){
        charactorRepository.update(charactorDto.toEntity());
    }

    public void update_name(CharactorDto charactorDto){
        charactorRepository.update_name(charactorDto.toEntity());
    }

}