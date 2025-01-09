package belousovdo.pkmn3.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import belousovdo.pkmn3.models.Card;
import belousovdo.pkmn3.service.CardService;
import belousovdo.pkmn3.service.PokemonTCGService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/v1/cards")
public class CardController {

    @Autowired
    private CardService cardService;

    @Autowired
    private PokemonTCGService pokemonTCGService;

    @GetMapping("")
    public List<Card> getAllCards() {
        System.out.println("getAllCards");
        return cardService.getAllCards();
    }

    @GetMapping("/{name}")
    public Card getCardByName(@PathVariable String name) {
        return cardService.getCardByName(name);
    }

    @GetMapping("/owner")
    public Card getCardByOwner(@RequestParam String firstName,
                               @RequestParam String surName,
                               @RequestParam String familyName) {
        return cardService.getCardByOwner(firstName, surName, familyName);
    }

    @GetMapping("/id/{id}")
    public Card getCardById(@PathVariable UUID id) {
        return cardService.getCardById(id);
    }

    @PostMapping("")
    public Card saveCard(@RequestBody Card card) {
        return cardService.saveCard(card);
    }

    @GetMapping("/image/{cardName}")
    public String getCardImage(@PathVariable String cardName) {
        return pokemonTCGService.getCardImageByName(cardName);
    }
}
