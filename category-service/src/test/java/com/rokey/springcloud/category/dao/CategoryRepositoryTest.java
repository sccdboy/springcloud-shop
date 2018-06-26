package com.rokey.springcloud.category.dao;

import com.rokey.springcloud.category.model.Category;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest()
@ActiveProfiles("test")
@Slf4j
public class CategoryRepositoryTest {

  @Autowired
  private CategoryRepository categoryRepository;

  @Test
  public void testWithNoParent() {

    Category electronic = Category.builder()
      .displayName("菜单一").level(1L).icon("/aa").value("electronic").seq(1L).build();

    Category saved = categoryRepository.save(electronic);
    assertThat(categoryRepository.findAll().contains(electronic));
    assertThat(saved.getParent() == null);
    assertThat(CollectionUtils.isEmpty(saved.getChildren()));
    assertThat(saved.getLevel().equals(1L));
  }

  @Test
  public void testWhenLevelTwo() {

    Category first = Category.builder()
        .displayName("菜单一").level(1L).icon("/aa").value("electronic").seq(1L).build();
    Category second1 = Category.builder()
        .displayName("菜单二").level(2L).icon("/bb").value("mobile").seq(1L).build();
    Category second2 = Category.builder()
        .displayName("菜单三").level(2L).icon("/cc").value("computer").seq(2L).build();
    categoryRepository.save(second1);
    categoryRepository.save(second2);
    first.setChildren(Arrays.asList(second1, second2));
    Category savedFirst = categoryRepository.save(first);
    List<Category> children = categoryRepository.findById(savedFirst.getId()).get().getChildren();
    assertThat(CollectionUtils.isNotEmpty(children));
    assertThat(children.size() == 2);
  }

  @Test
  public void testFindRoot() {

    Category first = Category.builder()
        .displayName("菜单一").level(1L).icon("/aa").value("electronic").seq(1L).build();
    Category second1 = Category.builder()
        .displayName("菜单二").level(2L).icon("/bb").value("mobile").seq(1L).build();
    Category second2 = Category.builder()
        .displayName("菜单三").level(2L).icon("/cc").value("computer").seq(2L).build();
    // 这里1对多的情况 要先保存一下
    second1.setParent(first);
    second2.setParent(first);
    categoryRepository.save(second1);
    categoryRepository.save(second2);
    first.setChildren(Arrays.asList(second1, second2));
    Category savedFirst = categoryRepository.save(first);
    Category root = categoryRepository.findRoot();
    assertThat(root.getDisplayName().equals("菜单一"));
    assertThat(root.getLevel().equals(1L));
    assertThat(root.getValue().equals("electronic"));
    assertThat(root.getParent() == null);
    assertThat(root.getChildren().size() == 2);

  }
}
