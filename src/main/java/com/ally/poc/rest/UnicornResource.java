package com.ally.poc.rest;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ally.poc.model.Unicorn;
import com.ally.poc.model.UnicornResponse;
import com.ally.poc.service.UnicornService;

@RestController
@RequestMapping("/api")
@Validated
public class UnicornResource {

	@Autowired
	private UnicornService unicornService;
	
	@PostMapping(value = "/unicorns")
	public ResponseEntity<UnicornResponse> addUnicorn(@RequestBody @Valid Unicorn unicorn) {
		return new ResponseEntity<UnicornResponse>(unicornService.createUnicorn(unicorn),HttpStatus.CREATED);
	}
	
	@GetMapping(value = "/unicorns")
	public ResponseEntity<List<Unicorn>> getUnicorns() {
		return new ResponseEntity<List<Unicorn>>(unicornService.getAllUnicorns(),HttpStatus.OK);
	}
	
	@PutMapping(value = "/unicorns/{unicornId}")
	public ResponseEntity<Unicorn> updateUnicorn(@PathVariable("unicornId") final long unicornId, @RequestBody Unicorn unicorn) {
		return new ResponseEntity<Unicorn>(unicornService.updateUnicorn(unicorn,unicornId),HttpStatus.OK);
	}
	
	@GetMapping(value = "/unicorns/{unicornId}")
	public ResponseEntity<Unicorn> getUnicorn(@PathVariable("unicornId") final long unicornId) {
		return new ResponseEntity<Unicorn>(unicornService.findUnicornById(unicornId),HttpStatus.OK);
	}
	
}
