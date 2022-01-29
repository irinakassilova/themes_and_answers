package com.example.exam_9_irina.controller;

import com.example.exam_9_irina.exception.ResourceNotFoundException;
import com.example.exam_9_irina.model.dto.ThemeDTO;
import com.example.exam_9_irina.repository.ThemeRepository;
import com.example.exam_9_irina.service.AnswerService;
import com.example.exam_9_irina.service.PropertiesService;
import com.example.exam_9_irina.service.ThemeService;
import com.example.exam_9_irina.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.nio.file.AccessDeniedException;
import java.security.Principal;

@Controller
@RequestMapping
@AllArgsConstructor
public class FrontendController {

    private final ThemeService themeService;
    private final AnswerService answerService;
    private final UserService userService;
    private final ThemeRepository themeRepository;

    private final PropertiesService propertiesService;

    private static <T> void constructPageable(Page<T> list, int pageSize, Model model, String uri, Sort name) {
        if (list.hasNext()) {
            model.addAttribute("nextPageLink", constructPageUri(uri, list.nextPageable().getPageNumber(), list.nextPageable().getPageSize()));
        }

        if (list.hasPrevious()) {
            model.addAttribute("prevPageLink", constructPageUri(uri, list.previousPageable().getPageNumber(), list.previousPageable().getPageSize()));
        }

        model.addAttribute("hasNext", list.hasNext());
        model.addAttribute("hasPrev", list.hasPrevious());
        model.addAttribute("items", list.getContent());
        model.addAttribute("defaultPageSize", pageSize);
    }

    private static String constructPageUri(String uri, int page, int size) {
        return String.format("%s?page=%s&size=%s", uri, page, size);
    }

    @GetMapping
    public String index(Model model, Pageable pageable,HttpServletRequest uriBuilder, Principal principal) {
        var themes = themeService.getThemes(pageable);
        var uri = uriBuilder.getRequestURI();
        constructPageable(themes, propertiesService.getDefaultPageSize(), model, uri, Sort.by(Sort.Direction.ASC, "title"));
        model.addAttribute("principal", principal);
        return "index";
    }

    @GetMapping("/themes/{id:\\d+?}")
    public String themePage(@PathVariable int id, Model model, Principal principal) {
        model.addAttribute("theme", themeService.getTheme(id));
        model.addAttribute("answers", answerService.getAnswer(id));
        model.addAttribute("principal", principal);
        return "theme";
    }

    @GetMapping("/themes/add")
    public String addTheme(Model model, Principal principal) {
        model.addAttribute("principal", principal);
        return "create_theme";
    }

    @PostMapping("/themes/add")
    public String addTheme(@Valid ThemeDTO themeDTO, @PathVariable String name) {
        themeService.addTheme(themeDTO, name);
        return "redirect:/";
    }

    @ExceptionHandler(AccessDeniedException.class)
    @ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
    private ResponseEntity<String> handleAccessDeniedException(AccessDeniedException ex) {
        return ResponseEntity.unprocessableEntity()
                .body(ex.getMessage());
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    private String handleRNF(ResourceNotFoundException ex, Model model) {
        model.addAttribute("resource", ex.getResource());
        model.addAttribute("id", ex.getId());
        return "resource-not-found";
    }
}

