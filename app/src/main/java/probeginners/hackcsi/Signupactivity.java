package probeginners.hackcsi;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.firebase.client.Firebase;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Signupactivity extends AppCompatActivity {
    Firebase reg;
    EditText ema,pass;
    private FirebaseAuth mAuth;

    private FirebaseAuth.AuthStateListener mAuthListener;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Constants.fun();
        //Firebase.setAndroidContext(this);
        //reg=new Firebase("https://chat-6c23a.firebaseio.com/registered_users");
        reg=new Firebase(Constants.registered_users);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signupactivity);
        ema=(EditText)findViewById(R.id.emailsu);
        pass=(EditText)findViewById(R.id.passwordsu);
        mAuth=FirebaseAuth.getInstance();
        mAuthListener=new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user=firebaseAuth.getCurrentUser();
                if (user != null) {
                    // User is signed in
                    Log.d("h", "onAuthStateChanged:signed_in:" + user.getUid());
                } else {
                    // User is signed out
                    Log.d("h", "onAuthStateChanged:signed_out");
                }

            }
        };
    }

    public void onClicks(View view) {

        if(view.getId()==R.id.signup){
            final String email=ema.getText().toString().trim();
            //(EditText)view.findViewById(R.id.emailsu)).getText().toString();
            String password=pass.getText().toString();
            if(!email.contains("@")||email.isEmpty())
                Toast.makeText(this,"Enter valid email address",Toast.LENGTH_SHORT).show();
            else if(password.length()<6)
                Toast.makeText(this,"Enter valid password greater than 5 characters",Toast.LENGTH_SHORT).show();
                //((EditText)view.findViewById(R.id.passwordsu)).getText().toString();

            else{mAuth.createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            Log.d("cs", "createUserWithEmail:onComplete:" + task.isSuccessful());
                            //reg.push().setValue(email
                            // If sign in fails, display a message to the user. If sign in succeeds
                            // the auth state listener will be notified and logic to handle the
                            // signed in user can be handled in the listener.
                            if (!task.isSuccessful()) {
                                Toast.makeText(Signupactivity.this, task.getException().toString(),
                                        Toast.LENGTH_SHORT).show();
                            } /*HashMap<String,Object> hashMap=new HashMap<String, Object>();
                                hashMap.put(email,email);
                                reg.updateChildren(hashMap);
                                reg.push().setValue(email);*/
                            Firebase firebase = new Firebase(Constants.registered_users);
                            Users users = new Users(email, "-", "-");
                            String to = Constants.convert1(email);
                            firebase.child(to).setValue(users);
                            Log.e("zigzag", email);
                            Toast.makeText(Signupactivity.this,"Signup Successful",Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(Signupactivity.this, SigninActivity.class);

                            startActivity(intent);
                        }


                        // ...

                    });
            }
        }
        else if(view.getId()==R.id.gotosigin){
            Intent intent=new Intent(this,SigninActivity.class);
            startActivity(intent);
        }
    }
    @Override
    public void onStart() {
        super.onStart();
        mAuth.addAuthStateListener(mAuthListener);
    }

    @Override
    public void onStop() {
        super.onStop();
        if (mAuthListener != null) {
            mAuth.removeAuthStateListener(mAuthListener);
        }
    }
}

