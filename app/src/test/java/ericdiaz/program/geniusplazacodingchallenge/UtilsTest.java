package ericdiaz.program.geniusplazacodingchallenge;

import org.junit.Assert;
import org.junit.Test;

import ericdiaz.program.geniusplazacodingchallenge.model.NewUser;
import ericdiaz.program.geniusplazacodingchallenge.model.User;
import ericdiaz.program.geniusplazacodingchallenge.utils.UserConverter;

public class UtilsTest {

    @Test
    public void TestConvertNewUserToSimpleUserMethodWithNullInput() {
        //given
        NewUser testNewUser = null;

        //when
        User converterResponse = UserConverter.convertNewUserToSimpleUser(testNewUser);

        //then
        Assert.assertEquals(User.EMPTY_USER, converterResponse);
    }
}
