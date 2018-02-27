package com.nmittal.mazeapp.service;

import java.util.Set;

import com.nmittal.maze.Block;
import com.nmittal.maze.IMaze;
import com.nmittal.mazeapp.domain.SolutionAlgorithms;

public interface IMazeService {

	IMaze getMaze(long mazeId);

	Set<Block> solveMaze(long mazeId, SolutionAlgorithms algorithm);

	SolutionAlgorithms[] getAvailableAlgorithms();

}
