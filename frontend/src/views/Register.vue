<template>
  <div id="register" class="text-center">
    <container class="login-image-container">

    </container>
    <form class="form-register" @submit.prevent="register">
      <div class="content">
        <h1 class="title">Create Account</h1>
        <div class="alert alert-danger" role="alert" v-if="registrationErrors">
          {{ registrationErrorMsg }}
        </div>
        <div class="input-fields">
          <label for="username" class="sr-only">Username</label>
          <input
            type="text"
            id="username"
            class="form-control"
            placeholder="Username"
            v-model="user.username"
            required
            autofocus
          />
          <label for="password" class="sr-only">Password</label>
          <input
            type="password"
            id="password"
            class="form-control"
            placeholder="Password"
            v-model="user.password"
            required
          />
          <input
            type="password"
            id="confirmPassword"
            class="form-control"
            placeholder="Confirm Password"
            v-model="user.confirmPassword"
            required
          />
          <button class="submit" type="submit">Create Account</button>
          <!-- <router-link :to="{ name: 'login' }" class="existing"
            >Have an account?</router-link
          > -->
        </div>
      </div>
    </form>
  </div>
</template>

<script>
import authService from "../services/AuthService";

export default {
  name: "register",
  data() {
    return {
      user: {
        username: "",
        password: "",
        confirmPassword: "",
        role: "user",
      },
      registrationErrors: false,
      registrationErrorMsg: "There were problems registering this user.",
    };
  },
  methods: {
    register() {
      if (this.user.password != this.user.confirmPassword) {
        this.registrationErrors = true;
        this.registrationErrorMsg = "Password & Confirm Password do not match.";
      } else {
        authService
          .register(this.user)
          .then((response) => {
            if (response.status == 201) {
              // this.$store.commit("SET_AUTH_TOKEN", response.data.token);
              // this.$store.commit("SET_USER", response.data.user);
              // this.$router.push({
              //   path: "/", 
              //   query: { registration: "success" },
              // });
              this.$router.push('/login')
            }            
          })
          .catch((error) => {
            const response = error.response;
            this.registrationErrors = true;
            if (response.status === 400) {
              this.registrationErrorMsg = "Bad Request: Validation Errors";
            }
          });
      }
    },
    clearErrors() {
      this.registrationErrors = false;
      this.registrationErrorMsg = "There were problems registering this user.";
    },
  },
};
</script>

<style>
@import url('https://fonts.googleapis.com/css2?family=Open+Sans:wght@300&display=swap');

* {
  font-family: 'Open Sans', sans-serif;
}

.form-register {
  display: inline-block;
  box-sizing: border-box;
  margin: auto;
  padding: 0;
  display: flex;
  justify-content: center;
  align-items: center;
  height: 100vh;
  border: none;
}

.content {
  background-color: white;
  height: 550px;
  width: 600px;
  border-radius: 8px;
  padding: 20px 40px;
  box-shadow: 0 0 1rem 0 rgba(0, 0, 0, 0.308); 
  border-radius: 15px;
  background-color: rgba(167, 167, 167, 0.329);
  backdrop-filter: blur(15px);
}

.title {
  font-size: 50px;
  margin-bottom: 50px;
  padding: 3px 0px 3px 3px;
  margin: 5px 1px 3px 0px;
}

.form-control {
  position: relative;
  height: 45px;
  width: 90%;
  margin-bottom: 18px;
  border-radius: 5px;
  text-align: center;
  font-size: 20px;
  -webkit-transition: all 0.2s ease-in-out;
  -moz-transition: all 0.2s ease-in-out;
  -ms-transition: all 0.2s ease-in-out;
  -o-transition: all 0.2s ease-in-out;
  outline: none;
}

.sr-only {
  display: inline;
  text-align: end;
  margin-bottom: 18px;
  font-size: 20px;
}

.input-fields {
  margin-top: 50px;
}

#username {
  margin-top: 20px;
  margin-bottom: 20px;
}

#password {
  margin-top: 20px;
  margin-bottom: 20px;
}

.submit {
  margin: 20px;
  background-color: #6046ED;
  box-shadow: 0px 4px 8px 0px #F887D6;
  width: 180px;
  height: 50px;
  font-size: 15px;
  color:white;
  border-radius: 8px
}

.submit:hover {
  background-color:  #7e68f7;
  transform: translateY(-2px);
}

.form-control:focus {
  box-shadow: 0 0 5px rgba(81, 203, 238, 1);
  padding: 3px 0px 3px 3px;
  margin: 5px 1px 3px 0px;
  border: 1px solid rgba(81, 203, 238, 1);
}

.existing {
  margin-top: 40px;
  font-size: 25px;
  color: black;
}
</style>
