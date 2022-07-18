package com.techelevator.controller;

import com.techelevator.dao.CatCardDao;
import com.techelevator.model.CatCard;
import com.techelevator.model.CatPic;
import com.techelevator.model.CatFact;
import com.techelevator.model.CatCardNotFoundException;
import com.techelevator.services.CatFactService;
import com.techelevator.services.CatPicService;
import org.apache.coyote.Request;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


public class CatController {

    private CatCardDao catCardDao;
    private CatFactService catFactService;
    private CatPicService catPicService;

    public CatController(CatCardDao catCardDao, CatFactService catFactService, CatPicService catPicService) {
        this.catCardDao = catCardDao;
        this.catFactService = catFactService;
        this.catPicService = catPicService;
    }



    // get request to get all cat cards
    @RequestMapping(method = RequestMethod.GET)
    public List<CatCard> list() {
        return catCardDao.list();
    }

    // get request to get a specific cat card by id
    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public CatCard get(@PathVariable int id) throws CatCardNotFoundException {
        return catCardDao.get(id);
    }

    public CatCard makeNewCard(){
        CatFact a = catFactService.getFact();
        CatPic b = catPicService.getPic();
        CatCard c = new CatCard();
        c.setCatFact(a.getText());
        c.setImgUrl(b.getFile());
        return c;

    }

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(method = RequestMethod.POST)
    public void save(@RequestBody CatCard catcard) {
       catCardDao.save(catcard);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.PUT)
    public void update(@Valid @RequestBody CatCard card, @PathVariable long id) throws CatCardNotFoundException {
        catCardDao.update(id, card);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable int id) throws CatCardNotFoundException {
        catCardDao.delete(id);
    }


    }
