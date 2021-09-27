<template>
  <div>
    <Navbar />
    <div class="container">
      <div class="Settings">
        <form>
          <div class="mb-3">
            <label for="fullname" class="form-label">Full Name</label>
            <input
              type="text"
              class="form-control"
              id="fullname"
              v-model="allSettings.fullname"
            />
            {{ allSettings.fullname }}
          </div>
          <div class="mb-3">
            <label for="location" class="form-label">Location</label>
            <input
              type="text"
              class="form-control"
              id="location"
              v-model="allSettings.location"
            />
            {{ allSettings.location }}
          </div>
          <div class="question_form mb-3">
            <label for="bio" class="form-label">Bio</label>
            <textarea
              class="form-control"
              aria-label="With textarea"
              rows="3"
              id="bio"
              v-model="allSettings.bio"
            ></textarea>
            {{ allSettings.bio }}
          </div>
          <div class="mb-3">
            <label for="username" class="form-label">Username</label>
            <input
              type="text"
              class="form-control"
              id="username"
              :value="allSettings.username"
              disabled
            />
          </div>
          <div class="mb-3">
            <div class="form-group">
              <label>Birth Date</label> <br />
              <el-date-picker
                v-model="allSettings.birthdate"
                type="date"
                placeholder="Pick a date"
              >
              </el-date-picker>
              {{ allSettings.birthdate }}
            </div>
          </div>
          <div class="mb-3 paddingwithborder">
            <label for="gender">Gender</label> <br />
            <select v-model="allSettings.gender">
              <option value="male">Male</option>
              <option value="female" selected>Female</option>
            </select>
            {{ allSettings.gender }}
          </div>

          <div class="changeprofile paddingwithborder">
            <label>photo</label> <br />
            <b-avatar :src="profileURL"></b-avatar>
            <input
              type="file"
              @change="onprofileselected"
              style="display:none"
              ref="fileinput"
            />
            <span @click="$refs.fileinput.click()">Change Photo</span>
          </div>

          <div class="changecover paddingwithborder">
            <label>Background</label> <br />
            <b-avatar :src="coverURL"></b-avatar>
            <input
              type="file"
              @change="oncoverselected"
              style="display:none"
              ref="fileinput1"
            />
            <span @click="$refs.fileinput1.click()"
              >Upload your background</span
            >
          </div>
          <div class="save_and_cancel">
            <button type="button" class="btn btn-danger"  @click.prevent="saveSetting">Save</button>
            <button type="button" class="btn btn-outline-dark">Cancel</button>
          </div>
        </form>
      </div>
    </div>
  </div>
</template>

<script>
import Navbar from "../components/nbar.vue";
export default {
  name: "Settings",
  data() {
    return {
      username: "omarrehan0020",
      selectedfile: "",
      profileURL: "",
      coverURL: "",
      profilePhoto:'',
      coverPhoto:'',
      allSettings: {
        fullname: "",
        location: "",
        bio: "",
        username: "omarrehan0020",
        birthdate: "",
        gender: "Male",
        profile: "",
        cover: "",
      },
    };
  },
  components: {
    Navbar,
  },
  methods: {
    onprofileselected: function(event) {
      this.allSettings.profile = event.target.files[0];
      let fd = new FormData();
      fd.append("image", this.allSettings.profile);
      this.profilePhoto = fd;
      /*fetch(
        "http://localhost:5050/setProfilePhoto/" + this.userID + "/" + this.userName,
        {
          method: "post",
          body: fd
        }
      );*/
      this.getImageBase64(this.allSettings.profile);
    },
    getImageBase64: function(file) {
      let reader = new FileReader();
      reader.readAsDataURL(file);
      reader.onload = () => {
        this.profileURL = reader.result;
      };
      reader.error = () => {
        alert("Error !!!");
      };
    },
    oncoverselected: function(event) {
      this.allSettings.cover = event.target.files[0];
      let fd = new FormData();
      fd.append("image", this.allSettings.cover);
      this.coverPhoto = fd;
      /*fetch(
        "http://localhost:5050/setCoverPhoto/" + this.userID + "/" + this.userName,
        {
          method: "post",
          body: fd
        }
      );*/
      this.getImageBase6(this.allSettings.cover);
    },
    getImageBase6: function(file) {
      let reader = new FileReader();
      reader.readAsDataURL(file);
      reader.onload = () => {
        this.coverURL = reader.result;
      };
      reader.error = () => {
        alert("Error !!!");
      };
    },
    saveSetting(){

      fetch(
        "http://localhost:5050/setProfilePhoto/" + this.userID + "/" + this.userName,
        {
          method: "post",
          body: this.profilePhoto,
        }
      );
      fetch(
        "http://localhost:5050/setCoverPhoto/" + this.userID + "/" + this.userName,
        {
          method: "post",
          body: this.coverPhoto,
        }
      );
    },
    async get(){
      const response = await fetch( "http://localhost:5050/getSettings/" + this.userID + "/" + this.userName, {
          method: "get", 
          headers: { "Content-Type": "application/json" },
      }).then((res) => {
          return res.json();
      }).then((data) => {
          console.log(data);
          return data;
      })
      console.log("bbbbbbbbb");
      console.log("questions response = " + response);
      this.allSettings.profile = response.profilePhoto;
      this.allSettings.cover = response.coverPhoto;
    }
  },
  computed:{
    userID(){
      return this.$store.state.userID;
    },
    userName(){
      return this.$store.state.userName;
    },
  },
  created() {
    this.get();
  },
};
</script>
<style scoped>
.Settings {
  background-color: #fff;
  width: 100%;
  border-radius: 10px;
  padding: 20px;
}
.container {
  width: 40%;
}
select {
  margin: 10px 20px 0 0;
  padding: 3px;
  height: 40px;
}
.paddingwithborder {
  padding-bottom: 20px;
  border-bottom: 6px solid #ddd;
}
.changecover {
  padding: 15px 0;
}
.changeprofile span,
.changecover span {
  cursor: pointer;
  color: #ee1144;
  font-size: 18px;
}
.changeprofile .b-avatar,
.changecover .b-avatar {
  width: 4rem;
  height: 4rem;
  margin: 10px 10px 10px 0;
}
.save_and_cancel {
  margin: 20px 0;
}
.save_and_cancel button {
  margin-right: 20px;
  min-width: 100px;
}
</style>
