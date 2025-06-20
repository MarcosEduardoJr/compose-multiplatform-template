# 🧭 Arrudeia – Gamified Travel App (Kotlin Multiplatform Mobile)

## 📖 Description

A mobile app using **Kotlin Multiplatform Mobile (KMP)** named **Arrudeia** – a playful and adventurous travel guide.

Think of it as a Pokémon GO for explorers – but without AR. Users explore real-world **tourist attractions**, **restaurants**, **accommodations**, and **local activities** on an interactive map, while unlocking **XP, collectibles, routes, and social connections**.

All shared logic must work cross-platform (Android & iOS) using KMP.

---

## 🛠️ Tech Stack

- **Kotlin Multiplatform Mobile (KMP)**
- **Ktor** – Networking
- **SQLDelight** – Local storage
- **Firebase** – Authentication, Firestore (DB), Storage (images)
- **Maps**:
  - Google Maps SDK (Android)
  - Apple MapKit (iOS)

---

## ⭐ Core Features

### 🔐 Authentication
- Firebase Authentication (email, phone, Google/Apple login)

### 🗺️ Interactive Map
- Custom markers with categories:
  - 🏛️ Tourist Spots
  - 🍽️ Food & Restaurants
  - 🛏️ Hotels & Hostels
  - 🎉 Events & Activities

### 🎮 Gamification
- XP for check-ins
- Achievements for thematic routes
- Leaderboards per region
- Daily missions and surprise rewards

### 👤 User Profile
- Avatar (customizable)
- Level and XP progress
- Badge gallery
- Travel stats (cities, countries, categories)

### 📍 Location Details
- Image carousel
- "I visited" button
- Leave comments and ratings
- Trivia or fun facts per location

### 💬 Social Interaction
- Nearby feed ("Who's exploring too?")
- Public chat per location or region
- Friend list & exploration parties

### 🔙 Backend
- Firestore – Real-time data
- Firebase Storage – Media (avatars, location images)
- SQLDelight – Local cache and offline mode

---

## 🎨 UI/UX Design Template

### 🎉 Theme Style: *Fun, Youthful & Adventurous*

#### 🎨 Color Palette
- `#00C897` – Vibrant Green (XP + action buttons)
- `#FF6B6B` – Coral Red (alerts, mission urgency)
- `#FFD93D` – Sunshine Yellow (rewards, surprises)
- `#4D4D4D` – Soft Charcoal (map overlays & text)
- `#FFFFFF` – Background
- `#F7F7F7` – Cards & panels

#### 🖋️ Font Choices
- **Titles**: `Fredoka` or `Baloo 2` (rounded, friendly)
- **Body text**: `Inter` or `Roboto` (clean and readable)

#### 🧩 Component Style
- Rounded corners (radius: 16dp)
- Shadowed cards for markers & popups
- Custom map pins with emoji or badge overlay
- XP bar: colorful gradient fill (green → yellow)
- Avatars in circular frames with level tag

#### 📱 UI Inspiration
- Pinterest + Duolingo + Google Maps
- Tabs: Explore | Missions | Map | Friends | Profile
- Explore feed: Scrollable cards with animated XP when completed
- Bottom nav with floating action button (for check-in)

---

## 🔐 Constraints
- ❌ No Augmented Reality (AR)
- ✅ Emphasis on **real-world map exploration**, **gamification**, and **social connection**
- 🔁 Shared logic via Kotlin Multiplatform (business logic, XP system, caching)