package com.mycompany.mygym.article.gathering.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mycompany.mygym.article.gathering.vo.Center;
import com.mycompany.mygym.article.gathering.vo.Gathering;

@Repository
@Transactional
public class ArticleDao implements ArticleDaoImpl {

	@Autowired
	private SqlSession session;
	
	Logger log = LogManager.getLogger("case3");

	// 만나 센터 별 게시글 수 확인
	@Override
//	public Gathering selectText(Gathering gathering) {
	public int selectText(Gathering gathering) {
		
		return session.selectOne("com.mycompany.mygym.article.gathering.selectCountList",gathering);
	}

	// 만나 센터의 게시글 리스트
	@Override
	public List<Gathering> selectGatheringList(Gathering gathering) {
		
		return session.selectList("com.mycompany.mygym.article.gathering.selectGatheringList",gathering);
	}

	// 만나 게시글의 상세보기
	@Override
	public Gathering selectInfo(Gathering gathering) {
		
		log.debug("dao"+gathering);
		
		Gathering result = session.selectOne("com.mycompany.mygym.article.gathering.selectGatheringInfo",gathering);
	
		log.debug("dao"+result);
		return result;
	}

	// 만나 게시글 작성
	@Override
	public int createArticle(Gathering gathering) {
		
		return session.insert("com.mycompany.mygym.article.gathering.createArticle",gathering);
	}

	@Override
	public int updateArticle(Gathering gathering) {
		
		return session.update("com.mycompany.mygym.article.gathering.updateInfo", gathering);
	}

	@Override
	public int deleteArticle(Gathering gathering) {
		
		return session.delete("com.mycompany.mygym.article.gathering.deleteInfo",gathering);
	}
	
	
	

}
