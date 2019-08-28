package ericdiaz.program.geniusplazacodingchallenge;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.inject.Inject;

import ericdiaz.program.geniusplazacodingchallenge.model.NewUser;
import ericdiaz.program.geniusplazacodingchallenge.model.UsersResponse;
import ericdiaz.program.geniusplazacodingchallenge.network.UserService;

public class RepositoryTest {
    private static final String TAG = "RepositoryTest";

    @Inject
    private UserService userService;

    @Before
    public void setUp() {
    }

    @Test
    public void testNetworkResponseAgainstPage1FirstUsersFirsName() {
        //given
        int page = 1;
        String expectedUserFirstName = "George";

        //when
        UsersResponse usersResponse = userService.getUsers(page).blockingFirst();

        //then
        Assert.assertEquals(expectedUserFirstName, usersResponse.getUsers().get(0).getFirstName());
    }

    @Test
    public void testNetworkResponseAgainstPage2ThirdUserEmail() {
        //given
        int page = 2;
        String expectedUserEmail = "tobias.funke@reqres.in";

        //when
        UsersResponse usersResponse = userService.getUsers(page).blockingFirst();

        //then
        Assert.assertEquals(expectedUserEmail, usersResponse.getUsers().get(2).getEmailAddress());
    }

    @Test
    public void testCreatingUserWithNewUser() {
        //given
        final NewUser testUser = new NewUser(0, "test@gmail.com", "cire", "zaid", null);

        //when
        NewUser newUserResponse = userService.createUser(
          testUser.getEmailAddress(),
          testUser.getFirstName(),
          testUser.getLastName())
          .blockingGet();

        //then
        Assert.assertEquals(newUserResponse.getFirstName(), testUser.getFirstName());
        Assert.assertEquals(newUserResponse.getTimeCreated().substring(0, 10), java.time.LocalDate.now().toString());
    }


    @After
    public void tearDown() {
        userService = null;
    }
}
