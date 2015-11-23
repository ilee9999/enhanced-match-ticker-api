package com.hkesports.matchticker.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hkesports.matchticker.model.Admin;
import com.hkesports.matchticker.model.Game;
import com.hkesports.matchticker.repository.AdminDao;
import com.hkesports.matchticker.repository.GameDao;
import com.hkesports.matchticker.repository.TeamDao;
import com.hkesports.matchticker.service.GameService;
import com.hkesports.matchticker.utils.Const;
import com.hkesports.matchticker.vo.getcontestantlist.GetcontestantlistVo;
import com.hkesports.matchticker.vo.getgamelist.GetgamelistVo;

@Transactional(readOnly = true)
@Service("gameService")
public class GameServiceImpl implements GameService {

	@Resource(name = "gameDao")
	private GameDao gameDao;
	@Resource(name = "teamDao")
	private TeamDao teamDao;
	@Resource(name = "adminDao")
	private AdminDao adminDao;
	
	@Override
	@Cacheable(value = "getGameList", key = "{#root.methodName}")
	public GetgamelistVo getGameList() {
		String iconRootPath = getRootIconPath();
		List<com.hkesports.matchticker.vo.getgamelist.GameVo> gameList = gameDao.findAllGames();
		for(com.hkesports.matchticker.vo.getgamelist.GameVo vo : gameList) {
			if(StringUtils.isNotBlank(iconRootPath)) {
				vo.setGameIconLarge(StringUtils.isNotBlank(vo.getGameIconLarge()) ? iconRootPath + vo.getGameID() + Const.FILE_SIZE_NAME_LARGE + vo.getGameIconLarge() : null);
				vo.setGameIconSmall(StringUtils.isNotBlank(vo.getGameIconSmall()) ? iconRootPath + vo.getGameID() + Const.FILE_SIZE_NAME_SMALL + vo.getGameIconSmall() : null);
			}
		}
		return new GetgamelistVo(gameList);
	}
	
	private String getRootIconPath() {
		Admin iconDomain = adminDao.findByKey(Const.ADMIN_KEY_ICON_DOMAIN);
		Admin iconPath = adminDao.findByKey(Const.ADMIN_KEY_ICON_PATH_GAME);
		if(iconDomain != null && iconPath != null) {
			return iconDomain.getValue() + iconPath.getValue();
		}
		return StringUtils.EMPTY;
	}

	@Override
	@Cacheable(value = "getContestantList", key = "{#root.methodName, #gameID}")
	public GetcontestantlistVo getContestantList(Long gameID) {
		GetcontestantlistVo vo = new GetcontestantlistVo();
		if(gameID==null) {
			return vo;
		}
		Game game = gameDao.findOne(gameID);
		vo.setTeam(game.getTeam());
		if(game.getTeam()) {
			vo.setContestants(teamDao.findAllTeamVoByGameId(gameID));
		} else {
			//TODO
		}
		return vo;
	}
}
