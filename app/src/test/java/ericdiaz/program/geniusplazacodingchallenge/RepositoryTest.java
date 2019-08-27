package ericdiaz.program.geniusplazacodingchallenge;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import ericdiaz.program.geniusplazacodingchallenge.model.UsersResponse;
import ericdiaz.program.geniusplazacodingchallenge.network.RetrofitServiceGenerator;
import ericdiaz.program.geniusplazacodingchallenge.network.UserService;

public class RepositoryTest {

    private UserService userService;

    @Before
    public void setUp() {
        userService = RetrofitServiceGenerator.getUserService();
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


    @After
    public void tearDown() {
        userService = null;
    }
}
