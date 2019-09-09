package ericdiaz.program.geniusplazacodingchallenge.repository

import ericdiaz.program.geniusplazacodingchallenge.model.NewUser
import ericdiaz.program.geniusplazacodingchallenge.model.UsersResponse
import ericdiaz.program.geniusplazacodingchallenge.network.UserService
import io.reactivex.Flowable
import io.reactivex.Single
import javax.inject.Inject

/**
 * A repository for conducting network call to User API
 *
 * Created 8/26/19
 *
 * @author Eric Diaz
 */

class UsersRepository(@Inject val userService: UserService) {

    fun getUsers(pageNumber: Int): Flowable<UsersResponse> {

        return userService.getUsers(pageNumber)
    }

    fun createUser(email: String,
                   firstName: String,
                   lastName: String): Single<NewUser> {

        return userService.createUser(email, firstName, lastName)
    }
}
