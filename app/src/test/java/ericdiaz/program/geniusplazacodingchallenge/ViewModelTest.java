package ericdiaz.program.geniusplazacodingchallenge;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import ericdiaz.program.geniusplazacodingchallenge.model.NewUser;
import ericdiaz.program.geniusplazacodingchallenge.model.User;
import ericdiaz.program.geniusplazacodingchallenge.utils.UserConverter;
import ericdiaz.program.geniusplazacodingchallenge.viewmodel.UsersViewModel;

public class ViewModelTest {

    private UsersViewModel usersViewModel;


    @Before
    public void setUp() {
        usersViewModel = new UsersViewModel();
    }

    @Test
    public void TestCreatingNewUserAndConversionToSimpleUser() {
        //given
        NewUser testNewUser = new NewUser(0, "some@aol.com", "bojack", "reeves", null);

        //when
        User userResponse = usersViewModel
          .createUser(
            testNewUser.getEmailAddress(),
            testNewUser.getFirstName(),
            testNewUser.getLastName()).blockingGet();

        //then
        Assert.assertEquals(testNewUser.getFirstName(), userResponse.getFirstName());
        Assert.assertEquals(testNewUser.getEmailAddress(), userResponse.getEmailAddress());
        Assert.assertEquals(UserConverter.DEFAULT_PROFILE_IMAGE_URL, userResponse.getPhotoUrl());
    }

}
