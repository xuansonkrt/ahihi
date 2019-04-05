package application.data.repository;

import application.data.model.Category;
import application.model.viewmodel.common.ChartLabelDataVM;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category,Integer> {

    @Query("select count(c.id) from dbo_category c")
    long getTotalCategories();

    @Query("select distinct  new application.model.viewmodel.common.ChartLabelDataVM(c.name,count(p.id)) " +
            "from dbo_category c inner  join c.listProducts p " +
            "group by c.id " +
            "order by c.name asc")
    List<ChartLabelDataVM> countProductByName();


//    @Query("select distinct  new application.model.viewmodel.common.ChartLabelDataVM(c.name,sum(op.amount)) " +
//            "from dbo_product p " +
//            "inner join dbo_category c on(p.categoryId=c.Id) " +
//            "inner join dbo_order_product op on (op.productId=p.Id) " +
//            "group by p.categoryId " +
//            "order by c.name asc")
    @Query("select distinct  new application.model.viewmodel.common.ChartLabelDataVM(c.name,sum(op.amount)) " +
            "from dbo_order_product op " +
            "inner join op.product p " +
            "inner join p.category c " +
            "group by p.categoryId " +
            "order by c.name asc")
    List<ChartLabelDataVM> countProductSold();


}
