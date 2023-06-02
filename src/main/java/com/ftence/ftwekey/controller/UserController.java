package com.ftence.ftwekey.controller;

import com.ftence.ftwekey.config.auth.PrincipalDetails;
import com.ftence.ftwekey.dto.response.*;
import com.ftence.ftwekey.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @GetMapping("/me")
    public UserMeInfoDTO getMyInfo(@AuthenticationPrincipal PrincipalDetails user) {

        return userService.getMyInfo(user);
    }

    @GetMapping("/{intraId}/info")
    public UserInfoDTO getUserInfo(@PathVariable String intraId) {

        return userService.getUserInfo(intraId);
    }

    @GetMapping("/{intraId}/comment")
    public List<UserCommentDTO> getUserComments(@PathVariable String intraId) {

        return userService.getUserComments(intraId);
    }

    @GetMapping("/me/like")
    public List<LikeCommentDTO> getUserLikeComments(@AuthenticationPrincipal PrincipalDetails user) {

        return userService.getUserLikeComments(user);
    }

    @GetMapping("/me/reviewed")
    public List<String> getReviewedSubjects(@AuthenticationPrincipal PrincipalDetails user) {

        return userService.getReviewedSubjects(user.getUser());
    }

    @GetMapping("/{intraId}/unreviewed")
    public List<UnreviewedSubjectDTO> getUnreviewedSubjects(@PathVariable String intraId) {

        return userService.getUnreviewedSubjects(intraId);
    }
}
