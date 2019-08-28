package ericdiaz.program.geniusplazacodingchallenge.view;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import ericdiaz.program.geniusplazacodingchallenge.R;
import ericdiaz.program.geniusplazacodingchallenge.model.NewUser;
import ericdiaz.program.geniusplazacodingchallenge.utils.StringChecker;
import ericdiaz.program.geniusplazacodingchallenge.view.constants.ViewConstants;

/**
 * A Activity for adding new users
 * <p>
 * Created 8/27/19
 *
 * @author Eric Diaz
 */

public class AddUserActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_user_layout);

        EditText firstNameEditText = findViewById(R.id.add_first_name_edit_text);
        EditText lastNameEditText = findViewById(R.id.add_last_name_edit_text);
        EditText emailEditText = findViewById(R.id.add_email_edit_text);
        Button createUserButton = findViewById(R.id.create_user_button);

        createUserButton.setOnClickListener(v -> {

            String firstNameInput = firstNameEditText.getText().toString();
            String lastNameInput = lastNameEditText.getText().toString();
            String emailInput = emailEditText.getText().toString();

            if (!StringChecker.isEmpty(firstNameInput)) {

                if (!StringChecker.isEmpty(lastNameInput)) {

                    if (!StringChecker.isEmpty(emailInput)) {

                        Intent returnIntent = new Intent();

                        returnIntent.putExtra(ViewConstants.NEW_USER,
                          new NewUser(0, emailInput, firstNameInput, lastNameInput, null));

                        setResult(RESULT_OK, returnIntent);

                        finish();
                    } else {
                        makeToast("Enter valid email");
                    }
                } else {
                    makeToast("Enter valid last name");
                }
            } else {
                makeToast("Enter valid first name");
            }
        });
    }

    private void makeToast(@NonNull final String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
