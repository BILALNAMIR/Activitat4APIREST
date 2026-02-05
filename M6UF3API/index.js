import express from "express";
import mongoose from "mongoose";
import dotenv from "dotenv";
import eventsRoutes from "./routes/events.routes.js";

dotenv.config();

const app = express();
app.use(express.json());

//connexio atlas
mongoose.connect(process.env.MONGO_URI)
  .then(() => console.log("Mongo connectat"))
  .catch(err => console.log(err));

app.use("/api/events", eventsRoutes);

app.listen(3000, () => {
  console.log("Servidor escoltant a port 3000");
});
