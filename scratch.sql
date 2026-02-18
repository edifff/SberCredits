CREATE TABLE credits (
                         deal_id SERIAL PRIMARY KEY,
                         credit_amount DECIMAL(10, 2) NOT NULL,
                         created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                         updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE payments (
                          payment_id SERIAL PRIMARY KEY,
                          deal_id INTEGER NOT NULL,
                          payment_date DATE NOT NULL,
                          payment_amount DECIMAL(10, 2) NOT NULL,
                          created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,

                          CONSTRAINT fk_payments_credits
                              FOREIGN KEY (deal_id)
                                  REFERENCES credits(deal_id)
                                  ON DELETE CASCADE,

                          CONSTRAINT unique_deal_payment_date
                              UNIQUE (deal_id, payment_date)
);