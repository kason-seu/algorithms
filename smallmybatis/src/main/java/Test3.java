import com.kason.SqlSession;
import com.kason.entity.ProductCategory;
import com.kason.mapper.ProductCategoryMapper;

public class Test3 {

    public static void main(String[] args) {


        ProductCategoryMapper mapper = SqlSession.getMapper(ProductCategoryMapper.class);

        ProductCategory p = new ProductCategory();
        p.setCategoryId(10001);
        p.setCategoryName("tets2");
        p.setCategoryType(2);
        int test = mapper.insert(p);
        System.out.println(test);




    }
}
