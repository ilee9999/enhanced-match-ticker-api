package com.hkesports.matchticker.web.controller;

import javax.annotation.Resource;

import net.rossillo.spring.web.mvc.CacheControl;
import net.rossillo.spring.web.mvc.CachePolicy;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hkesports.matchticker.service.KeepAliveService;
import com.hkesports.matchticker.vo.KeepaliveReqVo;
import com.hkesports.matchticker.vo.ResponseVo;
import com.hkesports.matchticker.vo.keepalive.KeepaliveVo;

/**
 * @author manboyu
 *
 */
@RestController
@RequestMapping(value = "rest/emt/api/v1")
public class EndUserController extends BasicController {

	@Resource(name = "invokeKeepAlive")
	private KeepAliveService invokeKeepAlive;
	
	@CacheControl(policy = {CachePolicy.NO_CACHE})
	@RequestMapping(value = "/keepalive", method = RequestMethod.GET)
	public ResponseVo<KeepaliveVo> keepalive(@ModelAttribute KeepaliveReqVo keepaliveReqVo) {
		return new ResponseVo<KeepaliveVo>(invokeKeepAlive.keepalive(keepaliveReqVo));
	}
}
