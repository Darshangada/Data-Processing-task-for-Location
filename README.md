# Location Data Processing

## Overview

This project processes location data from two JSON files to analyze and extract useful insights about different locations.

- **Location JSON**: Contains a list of locations with their `id`, `latitude`, and `longitude`.
- **Metadata JSON**: Provides additional details for each location, such as `type`, `rating`, and `reviews`.

## Steps to Complete the Task

### 1. Load and Parse JSON Files
- Read both JSON files into your preferred programming language (e.g., Java, Python).
- Ensure that the files are correctly loaded as lists of objects.

### 2. Merge Data Using `id`
- Use the `id` field as a unique key to link both datasets.
- Combine the location and metadata information based on matching `id`.

### 3. Count Locations per Type
- Determine the number of locations for each category (e.g., restaurant, hotel, cafe).

### 4. Calculate Average Rating per Type
- Compute the average rating for each location type.
- Exclude entries with missing or invalid ratings.

### 5. Find the Most Reviewed Location
- Identify the location with the highest number of reviews.

### 6. Identify Incomplete Data (Bonus Step)
- Detect entries where metadata is missing or locations have incomplete information.

## Final Output

### Count of locations per type
```json
{
  "cafe": 2,
  "restaurant": 3,
  "hotel": 3
}
```
===============================================
### Average rating per type:
```json
{
  "cafe" : 4.6,
  "restaurant" : 4.1,
  "hotel" : 3.4
}
```
===============================================
### Most reviewed location:
```json
{
  "id" : "loc_07",
  "reviews" : 900
}
```
