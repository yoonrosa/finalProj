package com.fin.proj.board.model.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.session.RowBounds;

import com.fin.proj.board.model.vo.Board;

@Mapper
public interface BoardDAO {

	int getListCount(int i);

	ArrayList<Board> selectBoardList(int i, RowBounds rowbounds);

}
