<template>
  <div id="register" class="text-center">
    <section>
      <img id="logo" src="GitForkedLogo.png"/>
    </section>
    <form class="form-register" @submit.prevent="register">
      <h1 class="h3 mb-3 font-weight-normal">Git Ready to Eat!</h1>
      <div class="alert alert-danger" role="alert" v-if="registrationErrors">
        {{ registrationErrorMsg }}
      </div>
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
      <router-link :to="{ name: 'login' }">Have an account?</router-link>
      <button class="btn btn-lg btn-primary btn-block" type="submit">
        Create Account
      </button>
    </form>
    <!-- <section>
      <img id="backgroundimg" src='https://images.unsplash.com/photo-1597652096872-658bf24731ec?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxzZWFyY2h8MjU5fHxwaXR0c2J1cmdofGVufDB8fDB8fA%3D%3D&auto=format&fit=crop&w=600&q=60'/>
    </section> -->
     <section>
      <img id="backgroundimg2" src="https://images.unsplash.com/photo-1555243896-771a81243361?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1123&q=80"/>
    </section>
  </div>
</template>

<script>
import authService from '../services/AuthService';

export default {
  name: 'register',
  data() {
    return {
      user: {
        username: '',
        password: '',
        confirmPassword: '',
        role: 'user',
      },
      registrationErrors: false,
      registrationErrorMsg: 'There were problems registering this user.',
    };
  },
  methods: {
    register() {
      if (this.user.password != this.user.confirmPassword) {
        this.registrationErrors = true;
        this.registrationErrorMsg = 'Password & Confirm Password do not match.';
      } else {
        authService
          .register(this.user)
          .then((response) => {
            if (response.status == 201) {
              this.$router.push({
                path: '/login',
                query: { registration: 'success' },
              });
            }
          })
          .catch((error) => {
            const response = error.response;
            this.registrationErrors = true;
            if (response.status === 400) {
              this.registrationErrorMsg = 'Bad Request: Validation Errors';
            }
          });
      }
    },
    clearErrors() {
      this.registrationErrors = false;
      this.registrationErrorMsg = 'There were problems registering this user.';
    },
  },
};
</script>

<style scoped>
@import url('https://fonts.googleapis.com/css2?family=Genos:ital,wght@1,100&display=swap');

#register {
  font-family: 'Genos', sans-serif;
  display: flex;
  justify-content: center;
  /* background-image: linear-gradient(to left, rgba(226, 240, 101, 0.479), rgba(113, 122, 124, 0.705)); */
  padding: 3rem;
  border-radius: 15px 50px 30px 5px;
  margin-right: 60px;
  margin-left: 60px;
}

label {
  display: flex;
  font-size: 20px;
  font-weight: bold;

}

a {
  display: flex;
  justify-content: left;
  font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
}

input {
  display: flex;
  justify-content: center;
  padding: 2px;
}

#backgroundimg {
  display: flex;
  justify-content: center;
  padding: 5rem;
  border-radius: 15px 50px 30px 5px;
}

#backgroundimg2 {
  position: relative;
  
}
#backgroundimg2 {
  position: absolute;
  width:125rem;
  padding: 200px;
  margin: -200px;
  left: 0px;
  top: 0px;
  z-index: -1;
}

#logo {
  width: 150px;
  height: auto;
 }
</style>
