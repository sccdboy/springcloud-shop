package com.rokey.springcloud.category.controller;

import com.rokey.springcloud.category.model.Category;
import com.rokey.springcloud.category.service.impl.CategoryService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(CategoryController.class)
@ActiveProfiles("test")
public class CategoryControllerTest {

  @Autowired
  private MockMvc mvc;

  @MockBean
  private  CategoryService categoryService;

  @Test
  public void testGetRoot() throws Exception {

    Category root = createRoot();
    given(categoryService.getRoot()).willReturn(root);

    mvc.perform(get("/category/root").accept(MediaType.APPLICATION_JSON))
          .andExpect(status().isOk())
          .andExpect(content().contentType("application/json;charset=UTF-8"))
          .andExpect(jsonPath("$.displayName").value("根菜单"))
          .andExpect(jsonPath("$.level").value(1L))
          .andExpect(jsonPath("$.value").value("root"))
          .andExpect(jsonPath("$.seq").value(1L));
  }

  private Category createRoot() {

    return Category.builder().seq(1L).value("root").icon("/root")
        .level(1L).displayName("根菜单").build();

  }
}
