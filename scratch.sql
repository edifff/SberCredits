DROP TABLE IF EXISTS payment_schedule CASCADE;
DROP TABLE IF EXISTS payments CASCADE;
DROP TABLE IF EXISTS credits CASCADE;

CREATE TABLE credits (
                         deal_id SERIAL PRIMARY KEY,
                         credit_amount DECIMAL(15,2) NOT NULL,
                         created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                         updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE payments (
                          payment_id SERIAL PRIMARY KEY,
                          deal_id INTEGER NOT NULL,
                          payment_date DATE NOT NULL,
                          payment_amount DECIMAL(15,2) NOT NULL,
                          created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                          CONSTRAINT fk_payments_credit
                              FOREIGN KEY (deal_id)
                                  REFERENCES credits(deal_id)
                                  ON DELETE CASCADE,

                          CONSTRAINT unique_payment
                              UNIQUE (deal_id, payment_date)
);

CREATE TABLE payment_schedule (
                                  payment_id SERIAL PRIMARY KEY,
                                  deal_id INTEGER NOT NULL,
                                  payment_date DATE NOT NULL,
                                  payment_amount DECIMAL(15,2) NOT NULL,
                                  principal_amount DECIMAL(15,2),
                                  interest_amount DECIMAL(15,2),
                                  created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,

                                  CONSTRAINT fk_schedule_credit
                                      FOREIGN KEY (deal_id)
                                          REFERENCES credits(deal_id)
                                          ON DELETE CASCADE
);

CREATE INDEX idx_payment_schedule_deal_date
    ON payment_schedule (deal_id, payment_date);