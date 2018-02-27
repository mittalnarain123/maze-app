package com.nmittal.mazeapp.service;

import java.util.Optional;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nmittal.maze.Block;
import com.nmittal.maze.IMaze;
import com.nmittal.maze.IMazeSolver;
import com.nmittal.mazeapp.dao.IMazeDao;
import com.nmittal.mazeapp.domain.SolutionAlgorithms;
import com.nmittal.mazeapp.error.MazeException;
import com.nmittal.mazeapp.util.SolutionFactory;

@Service
public class MazeService implements IMazeService {

	private static final Logger log = LoggerFactory.getLogger(MazeService.class);
	@Autowired
	private IMazeDao mazeDao;

	@Override
	public IMaze getMaze(long mazeId) {
		return Optional.ofNullable(mazeDao.getMaze(mazeId)).orElseThrow(() -> new MazeException("Maze not found"));
	}

	@Override
	public Set<Block> solveMaze(long mazeId, SolutionAlgorithms algorithm) {
		IMazeSolver solver = SolutionFactory.getMazeSolver(algorithm, getMaze(mazeId));
		if (solver.solve()) {
			log.debug("Found a solution");
			return solver.getSolutionPath();
		}
		return null;
	}

	@Override
	public SolutionAlgorithms[] getAvailableAlgorithms() {
		return SolutionAlgorithms.values();
	}

}
