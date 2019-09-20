import com.node3.cn.ProviderApplication;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
public class ApplicationTests {
    private Logger logger = Logger.getLogger(getClass());
    @Test
    public void test() throws Exception {
        logger.info("输出info2222222222222222222");
        logger.debug("输出debug22222222222222");
        logger.error("输出error2222222222222222");
    }

}
