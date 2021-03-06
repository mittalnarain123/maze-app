package com.nmittal.mazeapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.nmittal.maze.domain.IMaze;
import com.nmittal.mazeapp.domain.MazeGrid;
import com.nmittal.mazeapp.error.MazeException;
import com.nmittal.mazeapp.service.IMazeService;

@RestController
@RequestMapping("/maze")
public class MazeController {

	@Autowired
	private IMazeService mazeService;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public IMaze getMazeDefinition(@PathVariable("id") long mazeId) {
		return mazeService.getMaze(mazeId);

	}

	@RequestMapping(method = RequestMethod.POST)
	public IMaze createMazeDefinition(@RequestBody MazeGrid grid) {
		try {
			return mazeService.createMaze(grid.getRows(), grid.getCols());
		} catch (Exception e) {
			if (e instanceof IllegalArgumentException) {
				throw new MazeException(e.getMessage());
			} else {
				throw e;
			}
		}

	}

}
