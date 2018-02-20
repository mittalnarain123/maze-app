package com.nmittal.mazeapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.nmittal.maze.IMaze;
import com.nmittal.mazeapp.service.IMazeService;

@RestController
@RequestMapping("/maze")
public class MazeController {

	@Autowired
	private IMazeService mazeService;

	@RequestMapping(method = RequestMethod.GET)
	public IMaze getMazeDefinition() {
		return mazeService.getMaze();

	}

}
