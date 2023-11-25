package fubuki.ref.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fubuki.ref.character.CharacterService;

@RestController
@RequestMapping(path="/test", produces="application/json")
public class CharacterRestController {

	@Autowired
	CharacterService characterService;
	
}
