package com.aeon.oauth2;

import com.aeon.oauth2.server.Oauth2Application;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Oauth2Application.class)
public abstract class Oauth2ApplicationTestBase {

}
