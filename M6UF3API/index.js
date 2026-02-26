import express from "express";
import mongoose from "mongoose";
import dotenv from "dotenv";
import eventsRoutes from "./routes/events.routes.js";

dotenv.config();

const app = express();

app.use(express.json());
app.use(express.urlencoded({ extended: true }));

const clientOptions = {
  family: 4
};

mongoose.connect(process.env.MONGO_URI, clientOptions)
  .then(() => console.log("✅ Mongo connectat"))
  .catch(err => console.log("❌ Error:", err.message));

app.use("/api/events", eventsRoutes);

// Si quieres que funcione en local y en Vercel:
if (process.env.NODE_ENV !== "production") {
  app.listen(3000, () => {
    console.log("🚀 Servidor escoltant a port 3000");
  });
}

export default app;