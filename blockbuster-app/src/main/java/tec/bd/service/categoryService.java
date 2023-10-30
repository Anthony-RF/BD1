package tec.bd.service;


import java.util.List;
import java.util.Optional;
import tec.bd.entity.movieEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import static java.util.Objects.requireNonNull;
import tec.bd.entity.categoryEntity;
import tec.bd.entity.clientEntity;
public interface categoryService {

    List<categoryEntity> getCategories();

    Optional<categoryEntity> getCategoryById(int categoryId);

    categoryEntity newCategory(categoryEntity category);

    void removeCategory(int categoryId);

    categoryEntity updateCategory(categoryEntity category);
    void printCategory (categoryEntity category);

}